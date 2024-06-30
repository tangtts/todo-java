package com.tsk.todo.user;

import com.tsk.todo.resp.ResultResponse;
import com.tsk.todo.pojo.User;
import com.tsk.todo.req.LoginReq;
import com.tsk.todo.req.RegisterReq;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

  @Resource()
  private  UserService userService;



  @PostMapping("login")
  public ResultResponse<String> login(@Valid @RequestBody LoginReq login, HttpServletRequest httpServletRequest){

    return userService.login(login,httpServletRequest);
  }

  @PostMapping("/register")
  public ResultResponse<String> register(@Valid @RequestBody RegisterReq user){
    return userService.register(user);
  }
}
