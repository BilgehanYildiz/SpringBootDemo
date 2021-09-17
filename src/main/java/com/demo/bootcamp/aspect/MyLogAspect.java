package com.demo.bootcamp.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//Senaryo 11 Aspect Örneği
@Component
@Aspect
public class MyLogAspect {

    @Around(value = "within(com.demo..*.bll..*)")
    public Object logBllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName=methodSignature.getMethod().getName();
        System.out.println("method name:"+methodName);
        StringBuffer parameterList=new StringBuffer();
        Object[] arguments = proceedingJoinPoint.getArgs();
        ObjectMapper objectMapper=new ObjectMapper();

        for (Object parameter:arguments) {

            parameterList.append("Parametre:"+objectMapper.writeValueAsString(parameter));
        }
        System.out.println(parameterList.toString());

        Object result=proceedingJoinPoint.proceed();
        System.out.println("Result"+objectMapper.writeValueAsString(result));
        return result;
    }
}
