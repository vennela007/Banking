package com.ing.bank.service;

import java.lang.reflect.InvocationTargetException;

import com.ing.bank.dto.UserDTO;

public interface LoginService {

	UserDTO login(String loginName, String password) throws IllegalAccessException, InvocationTargetException;

}
