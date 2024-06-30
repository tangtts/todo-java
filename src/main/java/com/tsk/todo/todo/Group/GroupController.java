package com.tsk.todo.todo.Group;

import com.tsk.todo.resp.ResultResponse;
import com.tsk.todo.pojo.Todo;
import com.tsk.todo.req.TodoGroupReq;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Tsk
 * @date 2024/6/26 0026
 */
@Slf4j
@RestController
@RequestMapping("/group")
public class GroupController {

    @Resource
    GroupService groupService;

    @GetMapping("/getGroup")
    public ResultResponse<List<Map<String, Object>>> getGroup(@RequestParam(value = "groupName", required = false) String groupName, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        return groupService.getGroup(groupName,userId);
    }

    @PostMapping("/addGroup")
    public ResultResponse<String> addGroup(@Validated @RequestBody TodoGroupReq todoGroup, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        return groupService.addGroup(todoGroup,userId);
    }

    @GetMapping("/getAllComplete")
    public ResultResponse<List<Todo>> getAllComplete(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        return groupService.getAllComplete(userId);
    }
    @GetMapping("/getAllMarked")
    public ResultResponse<List<Todo>> getAllMarked(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        return groupService.getAllMarked(userId);
    }

    @GetMapping("/deleteGroup")
    ResultResponse<String> deleteTodo(@RequestParam Integer groupId) {
        return groupService.deleteGroup(groupId);
    }
}
