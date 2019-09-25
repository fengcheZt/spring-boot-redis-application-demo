package com.spring.redis.application.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>用户实体</p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -1376384018240032721L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;
}
