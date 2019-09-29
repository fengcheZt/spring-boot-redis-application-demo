package com.spring.redis.application.rank.controller;

import com.spring.redis.application.rank.component.RankListComponent;
import com.spring.redis.application.rank.modal.RankDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by @author yihui in 20:16 18/12/25.
 */
@Api(tags = "UserController", description = "redis排行榜")
@RestController
public class RankController {
    @Autowired
    private RankListComponent rankListComponent;

    @ApiOperation("前几排行")
    @GetMapping(path = "/topn")
    public List<RankDO> showTopN(int n) {
        return rankListComponent.getTopNRanks(n);
    }

    @ApiOperation("更新")
    @GetMapping(path = "/update")
    public RankDO updateScore(long userId, float score) {
        return rankListComponent.updateRank(userId, score);
    }

    @ApiOperation("用户名次")
    @GetMapping(path = "/rank")
    public RankDO queryRank(long userId) {
        return rankListComponent.getRank(userId);
    }

    @ApiOperation("获取用户所在排行榜的位置")
    @GetMapping(path = "/around")
    public List<RankDO> around(long userId, int n) {
        return rankListComponent.getRankAroundUser(userId, n);
    }

}
