package com.junhow.gp.controller;

import com.junhow.gp.common.ResponseBean;
import com.junhow.gp.exception.CustomException;
import com.junhow.gp.pojo.Proposal;
import com.junhow.gp.service.IProposalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junhow.gp.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProposalController
 * @author CodeGenerator
 * @date 2019/03/16 18:13
 */
@RestController
@RequestMapping("/proposal")
public class ProposalController {
    @Autowired
    private IProposalService proposalService;

    @Autowired
    private WebSocketServer webSocketServer;
    /**
     * 列表
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (page <= 0 || limit <= 0) {
            page = 1;
            limit = 10;
        }
        PageHelper.startPage(page, limit);
        List<Proposal> list = proposalService.selectAll();
        if (list == null || list.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        PageInfo<Proposal> pageInfo = new PageInfo<Proposal>(list);
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("code", 0);
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

    /**
     * 查询
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/detail")
    public ResponseBean detail(@RequestParam Integer id) {
        Proposal proposal = proposalService.selectByPrimaryKey(id);
        if (proposal == null) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", proposal);
    }

    /**
     * 新增
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody Proposal proposal) {
        proposal.setResolved("未解决");
        int count = proposalService.insert(proposal);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        for ( WebSocketServer admin : WebSocketServer.getWebSocketSetForAdmin()){
            admin.sendMessage("1");
        }
        return new ResponseBean(200, "新增成功(Insert Success)", proposal);
    }

    /**
     * 更新
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @PostMapping("/update/{id}")
    public ResponseBean update(@PathVariable Integer id, @RequestBody Proposal proposal) {
        proposal.setId(id);
        int count = proposalService.updateByPrimaryKeySelective(proposal);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(200, "更新成功(Update Success)", proposal);
    }

    /**
     * 删除
     * @author CodeGenerator
     * @date 2019/03/16 18:13
     */
    @RequestMapping("/delete")
    public ResponseBean delete(@RequestBody List<Proposal> ids) {
        for (Proposal id : ids) {
            int count = proposalService.deleteByPrimaryKey(id);
            if (count <= 0) {
                throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
            }
        }
        return new ResponseBean(200, "删除成功(Delete Success)", null);
    }

    @RequestMapping("/message")
    public ResponseBean message() {
        Proposal proposal = new Proposal();
        proposal.setResolved("未解决");
        Integer num = proposalService.selectCount(proposal);
        return new ResponseBean(200, "删除成功(Delete Success)", num);
    }
}
