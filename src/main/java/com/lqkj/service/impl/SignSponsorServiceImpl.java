package com.lqkj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqkj.dao.SignInSendMessageDao;
import com.lqkj.dao.StudentInfoDao;
import com.lqkj.dao.TeacherInfoDao;
import com.lqkj.domain.SignInSendMessage;
import com.lqkj.domain.SignInSponsor;
import com.lqkj.repository.MessageRepository;
import com.lqkj.repository.SignInSponsorRepository;
import com.lqkj.service.SignSponsorService;

/**
 * Created by lijunhong on 17/11/6.
 * 发起签到INFO
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

    @Autowired
    private MessageRepository messageRepository;





    @Override
    @Transactional
    public void saveSponsor(SignInSponsor signInSponsor) {

        signInSponsor.setIs_open(true);//给一个默认值
        signInSponsor.setSign_in_scope(200);
        signInSponsor.setCreatetime(new Date());
        SignInSponsor entity = repository.save(signInSponsor);
        StringBuffer sb = null;
        SignInSendMessage message = null;

        int value = signInSponsor.getMessage_status();
        if(entity.getId() == null)
            throw new RuntimeException("推送没有正常返回id");

        if(value == 0) {
            sb = new StringBuffer();
            //代表全校0
            Set<String> teacherCode = teacherInfoDao.getAllTeacherCode();
            String studentCode = studentInfoDao.getAllStudentCode();
            sb.append(studentCode);
            for (String t:teacherCode) {
                sb.append(",");
                sb.append(t);
            }

            message = new SignInSendMessage();
            message.setCode(sb.toString());
            message.setSponsor_id(entity.getId());
            messageRepository.save(message);


        }else if(value == 1) {
            //代表教师1
            sb = new StringBuffer();
            message = new SignInSendMessage();
            Set<String> teachers = teacherInfoDao.getAllTeacherCode();
            List<String> list = new ArrayList<>(teachers);
            for(int i = 0;i < list.size();i++) {
                if(i <= 1) {
                    sb.append(list.get(i));
                }else {
                    sb.append(",");
                    sb.append(list.get(i));
                }
            }
            message.setSponsor_id(entity.getId());
            message.setCode(sb.toString());
            messageRepository.save(message);
        }else if(value == 2) {
            //代表学生2
            String studentCode = studentInfoDao.getAllStudentCode();
            message = new SignInSendMessage();
            message.setCode(studentCode);
            message.setSponsor_id(entity.getId());
            messageRepository.save(message);
        }
    }
}
