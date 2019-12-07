package com.perye.dokit.entity;

import com.perye.dokit.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "quartz_job")
public class QuartzJob extends BaseEntity {

    public static final String JOB_KEY = "JOB_KEY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = {Update.class})
    private Long id;

    // 定时器名称
    @Column(name = "job_name")
    private String jobName;

    // Bean名称
    @Column(name = "bean_name")
    @NotBlank
    private String beanName;

    // 方法名称
    @Column(name = "method_name")
    @NotBlank
    private String methodName;

    // 参数
    @Column(name = "params")
    private String params;

    // cron表达式
    @Column(name = "cron_expression")
    @NotBlank
    private String cronExpression;

    // 状态
    @Column(name = "is_pause")
    private Boolean isPause = false;

    // 备注
    @Column(name = "remark")
    @NotBlank
    private String remark;

}
