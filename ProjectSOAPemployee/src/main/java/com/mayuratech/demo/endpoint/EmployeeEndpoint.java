package com.mayuratech.demo.endpoint;

import com.mayuratech.demo.AddEmployeeRequest;
import com.mayuratech.demo.AddEmployeeResponse;
import com.mayuratech.demo.EmployeeInfo;
import com.mayuratech.demo.GetEmployeeResponse;
import com.mayuratech.demo.GetEmployeebyIdRequest;
import com.mayuratech.demo.ServiceStatus;
import com.mayuratech.demo.entity.*;
import com.mayuratech.demo.service.Service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//@Slf4j
@Endpoint
//@RequiredArgsConstructor
public class EmployeeEndpoint{
	
	@Autowired
    private  Service service;

    private static final String NAMESPACE_URI = "http://com.mayuratech.demo";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addemployee(@RequestPayload AddEmployeeRequest request) {
    	AddEmployeeResponse response = new AddEmployeeResponse();
        ServiceStatus serviceStatus= new ServiceStatus();
        
        Employee employee = new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
        service.addEmployee(employee);
        serviceStatus.setStatus("SUCCESS..");
        serviceStatus.setMesssage("Ëmployee Added Succesfully");
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeebyIdRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployeesById(@RequestPayload GetEmployeebyIdRequest request) {
    	GetEmployeeResponse response = new GetEmployeeResponse();
        
        EmployeeInfo employeeInfo = new EmployeeInfo();
        Optional<Employee> employeeById = service.getEmployeeById(request.getEmployeeid());
      BeanUtils.copyProperties(employeeById.get(),employeeInfo);
      employeeInfo.setEmployeeid(request.getEmployeeid());
        response.setEmployeeInfo(employeeInfo);
        return response;
    }
}