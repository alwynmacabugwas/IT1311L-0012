package com.uap.it1311l.passwordencryptorapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface credentialsMybatisRepository 
{
		@Insert("INSERT INTO credentials(encryptedPassword) VALUES (#{password})")
		public void insert(String password);
		
		@Select("SELECT COUNT(*) FROM credentials WHERE encryptedPassword = #{password}")
	    public int exists(String password);
}