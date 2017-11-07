package com.lqkj.controller.push;

import com.lqkj.common.jpush.JPushClientExample;
import com.lqkj.dao.ViewPublicSignNowDao;
import com.lqkj.domain.vo.ViewPublicSignNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.*;

public class SchedulePush {

    @Value("${JPUSH.APPKEY}")
    private String APPKEY;

    @Value("${JPUSH.MASTERSECRET}")
    private String MASTERSECRET;

    @Autowired
    private ViewPublicSignNowDao viewPublicSignNowDao;

    @Scheduled(cron = "0 1 * * * ?")
    public void push(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String now = sdf.format(new Date());

        List<ViewPublicSignNow> list = viewPublicSignNowDao.queryPushList(now);
        if(list.size() > 0){
            JPushClientExample jpush = new JPushClientExample(APPKEY, MASTERSECRET);
            for(ViewPublicSignNow vpsn : list){
                List<String> tagList = new ArrayList<String>();
                String[] tagArray = vpsn.getCode().split(",");
                for(String str : tagArray){
                    tagList.add(str);
                }

                Map<String, String> map = new HashMap<String, String>();
                map.put("type", "2");
                map.put("id",vpsn.getId() + "");
                map.put("longitude", vpsn.getLongitude() + "");
                map.put("latitude", vpsn.getLatitude() + "");
                map.put("sponsor_name", vpsn.getSponsor_name());
                map.put("starttime", vpsn.getStarttime());
                map.put("endtime", vpsn.getEndtime());
                map.put("sign_in_name", vpsn.getSponsor_name());
                jpush.tagSendMsg("签到提醒", "有公共签到开始进行签到了，点击签到", map, tagList);
            }
        }
    }
}
