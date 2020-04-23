package com.bdqn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiaopy
 * @date 2020/3/19 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment implements Serializable {
    private Long id;
    private String serial;
}