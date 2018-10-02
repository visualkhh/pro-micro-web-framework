package com.mwf.config.component;

import com.mwf.config.anno.RequestMapping;
import com.mwf.model.Request;
import com.mwf.model.Response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ComponentManager {
    private static ComponentManager instance;
    private List<Object> controller;

    private ComponentManager () {}
    static {
        try {
//            System.out.println("instance create..");
            instance = new ComponentManager();
        } catch (Exception e) {
            throw new RuntimeException("Exception creating StaticBlockInitalization instance.");
        }
    }

    public static ComponentManager getInstance () {
        return instance;
    }

    public void setController(List<Object> controllers) {
        this.controller = controllers;
    }
    public Object executeController(String url, String method, Request request, Response response) throws InvocationTargetException, IllegalAccessException {
//        this.controller.stream().forEach();
        for(Object controller : this.controller){
            Method[] methods = this.getAnnotationMethods(controller.getClass(), RequestMapping.class);
            for(Method it : methods) {
                RequestMapping itA = it.getAnnotation(RequestMapping.class);
                if(itA.value().equals(url) && itA.method().equals(method)){
                    it.invoke(controller, request, response);
                }
            }
        }

        return null;
    }



    public Method[] getAnnotationMethods(Class classclass, Class annoClass) {
        ArrayList<Method> fieldArray = new ArrayList();
        Method[] fields = this.getDeclaredMethods(classclass);

        for(int i = 0; i < fields.length; ++i) {
            Method elem = fields[i];
            if (elem != null && elem.isAnnotationPresent(annoClass)) {
                fieldArray.add(elem);
            }
        }

        return (Method[])fieldArray.toArray(new Method[fieldArray.size()]);
    }

    public Method[] getDeclaredMethods(Class at) {
        Method[] methods = at.getDeclaredMethods();
        return methods;
    }

}
