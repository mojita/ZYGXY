package com.lqkj.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqkj.dao.SignInSendMessageDao;
import com.lqkj.dao.StudentInfoDao;
import com.lqkj.dao.TeacherInfoDao;
import com.lqkj.domain.SignInSendMessage;
import com.lqkj.domain.SignInSponsor;
import com.lqkj.repository.SignInSponsorRepository;
import com.lqkj.service.SignSponsorService;

/**
 * Created by lijunhong on 17/11/6.
 */
@Service
public class SignSponsorServiceImpl implements SignSponsorService{

    @Autowired
    private SignInSponsorRepository repository;

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Autowired
    private SignInSendMessageDao sendMessageDao;





    @Override
    @Transactional
    public void saveSponsor(SignInSponsor signInSponsor) {
        //TODO 这里需要进行判断全校还是教师或学生

        signInSponsor.setCreatetime(new Date());
        //TODO 这里是进行保存发起签到的实体返回id(测试需注意是否正确返回实体)
        SignInSponsor entity = repository.save(signInSponsor);
        StringBuffer sb = null;



        int value = signInSponsor.getMessage_status();
        if(value == 0) {
            sb = new StringBuffer();
            //代表全校
            //TODO 这里数据库链接不上就先进性本地测试
//            Set<String> teacherCode = teacherInfoDao.getAllTeacherCode();
            Set<String> teacherCode = new TreeSet<>();
            teacherCode.add("1");
            teacherCode.add("1");
            teacherCode.add("1");
            teacherCode.add("1");
            teacherCode.add("1");
            String student = "1,2,3,4,5";
            sb.append(student);
            for(String s: teacherCode) {
                sb.append(",");
                sb.append(s);
            }

            SignInSendMessage message = new SignInSendMessage();
            message.setCode(sb.toString());
            //TODO 这里很可能取到的是null
            if(entity.getId() == null)
                throw new RuntimeException("推送没有正常返回id");

            message.setSponsor_id(entity.getId());

//            sendMessageDao.saveSendMessage();

//            String studentCode = studentInfoDao.getAllStudentCode();
        }else if(value == 1) {
            //代表教师
            sb = new StringBuffer();
            Set<String> teachers = teacherInfoDao.getAllTeacherCode();
            List<String> list = new ArrayList<>(teachers);
            for(int i = 0;i<list.size();i++) {
                if(i <= 1) {

                }
            }

        }else if(value == 2) {
            sb = new StringBuffer();
        }


    }
}
