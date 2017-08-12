package com.semihunaldi.kotlin.springbootkotlintest.services

import mock.backend.api.config.properties.AppProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
abstract class BaseServiceImpl
{
    protected val logger: org.slf4j.Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    protected var appProperties: AppProperties? = null
}