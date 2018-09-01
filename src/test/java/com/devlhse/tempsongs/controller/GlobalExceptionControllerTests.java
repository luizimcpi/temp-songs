package com.devlhse.tempsongs.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GlobalExceptionControllerTests {

    private Exception e;

    @InjectMocks
    private GlobalExceptionController globalExceptionController;

    @Before
    public void setUp(){
        e = new Exception();
    }

    @Test
    public void shouldHandleNotFoundExceptionWithSuccess() {
        Assert.assertNotNull(globalExceptionController.handleNotFoundException(e));
    }

    @Test
    public void shouldHandleBadRequestExceptionWithSuccess() {
        Assert.assertNotNull(globalExceptionController.handleBadRequestException(e));
    }

    @Test
    public void shouldHandleUnauthorizedExceptionWithSuccess() {
        Assert.assertNotNull(globalExceptionController.handleUnauthorizedException(e));
    }
}
