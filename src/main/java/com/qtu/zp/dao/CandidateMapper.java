package com.qtu.zp.dao;

import com.qtu.zp.domain.Candidate;
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
