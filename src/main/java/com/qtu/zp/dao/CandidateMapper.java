package com.qtu.zp.dao;

import com.qtu.zp.domain.Candidate;
import com.qtu.zp.domain.CandidateMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: AmberXu
 * @Date: 2019/4/10 10:28
 */
@Mapper
public interface CandidateMapper {

    public List<Candidate> getAllCandidate();
//     通过电话号码获取用户信息
    Candidate findCandidateByPhone(String phone);

//    修改密码
    void updatePassword(String phone,String cpassword);

    void updateIntroduce(String phone,String introduce);

    List<CandidateMessage> getCandidateMessageByPhone(String phone);

    void updateCandidate(Candidate candidate);

    void updateCandidateMessage(CandidateMessage candidateMessage);

//    修改求职者信息
    void updateCandidateBaseInfo(CandidateMessage candidateMessage);

//    注册求职者
    void addCandidate(Candidate candidate);
    void addCandidateMessage(CandidateMessage candidateMessage);
//    @Select("select * from employee limit #{currpage},#{pagecount}")
//    List<Employee> allemps(Integer currpage, Integer pagecount);
//
//    @Select("select count(*) from employee")
//    Integer getempsnum();




//    @Insert("insert into employee values(null,#{ename},#{phone},#{did},#{face})")
//    Integer addemps(Employee emp);
//
//    @Update("<script>" +
//            "update employee set " +
//            "<if test=\"#{ename} !=null and !#{ename}.equals('') \"> ename=#{ename},</if>" +
//            "<if test=\"#{phone} !=null and !#{phone}.equals('') \"> phone=#{phone},</if>" +
//            "<if test=\"#{did} !=null and !#{did}.equals('') \"> did=#{did},</if>" +
//            "<if test=\"#{face} !=null and !#{face}.equals('') \"> face=#{face}</if>" +
//            " where eid=#{eid} </script>")
//    Integer updemps(Employee emp);
//
//    @Delete("delete from employee where eid=#{eid}")
//    Integer delemps(Integer eid);
}
