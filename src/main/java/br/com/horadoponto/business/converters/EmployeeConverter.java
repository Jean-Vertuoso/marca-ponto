package br.com.horadoponto.business.converters;

import br.com.horadoponto.infrastructure.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.horadoponto.controllers.dto.AddressDTO;
import br.com.horadoponto.controllers.dto.DepartmentDTO;
import br.com.horadoponto.controllers.dto.EmployeeDTO;
import br.com.horadoponto.controllers.dto.PhoneDTO;
import br.com.horadoponto.infrastructure.entities.Address;
import br.com.horadoponto.infrastructure.entities.Department;
import br.com.horadoponto.infrastructure.entities.Employee;
import br.com.horadoponto.infrastructure.entities.Phone;

@Component
public class EmployeeConverter {

    @Autowired
    private DepartmentRepository departmentRepository;

    // PARTE QUE CONVERTE DE DTO PARA DTO
    public Employee toEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setPassword(employeeDTO.getPassword());
        employee.setStatus(employeeDTO.getStatus());
        employee.setDepartment(departmentRepository.getReferenceById(employeeDTO.getDepartment().getId()));
        employee.getAddresses().addAll(employeeDTO.getAddresses().stream().map(this::toAddress).toList());
        employee.getPhones().addAll(employeeDTO.getPhones().stream().map(this::toPhone).toList());

        return employee;
    }

    public Address toAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setZipCode(addressDTO.getZipCode());
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());

        return address;
    }

    public Phone toPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone();
        phone.setDdd(phoneDTO.getDdd());
        phone.setNumber(phoneDTO.getNumber());

        return phone;
    }

    public Department toDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());

        return department;
    }

    // PARTE QUE CONVERTE DE DTO PARA ENTIDADE
    public EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setBirthDate(employee.getBirthDate());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setStatus(employee.getStatus());
        employeeDTO.setDepartment(toDepartmentDTO(departmentRepository.getReferenceById(employee.getDepartment().getId())));
        employeeDTO.getAddresses().addAll(employee.getAddresses().stream().map(this::toAddressDTO).toList());
        employeeDTO.getPhones().addAll(employee.getPhones().stream().map(this::toPhoneDTO).toList());
        return employeeDTO;
    }

    public AddressDTO toAddressDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setZipCode(address.getZipCode());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());

        return addressDTO;
    }

    public PhoneDTO toPhoneDTO(Phone phone){
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setDdd(phone.getDdd());
        phoneDTO.setNumber(phone.getNumber());

        return phoneDTO;
    }

    public DepartmentDTO toDepartmentDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());

        return departmentDTO;
    }
}
