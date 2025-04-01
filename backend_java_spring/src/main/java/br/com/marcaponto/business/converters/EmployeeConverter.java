package br.com.marcaponto.business.converters;

import br.com.marcaponto.business.dto.in.AddressDTORequest;
import br.com.marcaponto.business.dto.in.EmployeeDTORequest;
import br.com.marcaponto.business.dto.in.PhoneDTORequest;
import br.com.marcaponto.business.dto.out.AddressDTOResponse;
import br.com.marcaponto.business.dto.out.DepartmentDTOResponse;
import br.com.marcaponto.business.dto.out.EmployeeDTOResponse;
import br.com.marcaponto.business.dto.out.PhoneDTOResponse;
import br.com.marcaponto.infrastructure.entities.Address;
import br.com.marcaponto.infrastructure.entities.Department;
import br.com.marcaponto.infrastructure.entities.Employee;
import br.com.marcaponto.infrastructure.entities.Phone;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeConverter {

    public Employee toEmployee(EmployeeDTORequest employeeDTO){
        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setPassword(employeeDTO.getPassword());
        employee.setStatus(employeeDTO.getStatus());
        employee.setDepartment_id(employeeDTO.getDepartment_id());
        employee.getAddresses().addAll(toAddressList(employeeDTO));
        employee.getPhones().addAll(toPhoneList(employeeDTO));

        return employee;
    }

    public List<Address> toAddressList(EmployeeDTORequest employeeDTO){
        return employeeDTO.getAddresses().stream().map(this::toAddress).toList();
    }

    public List<Phone> toPhoneList(EmployeeDTORequest employeeDTO){
        return employeeDTO.getPhones().stream().map(this::toPhone).toList();
    }

    public Address toAddress(AddressDTORequest addressDTO){
        Address address = new Address();
        address.setZipCode(addressDTO.getZipCode());
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setNeighborhood(addressDTO.getNeighborhood());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());

        return address;
    }

    public Phone toPhone(PhoneDTORequest phoneDTO){
        Phone phone = new Phone();
        phone.setDdd(phoneDTO.getDdd());
        phone.setNumber(phoneDTO.getNumber());

        return phone;
    }

    public EmployeeDTOResponse toEmployeeDTO(Employee employee){
        EmployeeDTOResponse employeeDTO = new EmployeeDTOResponse();

        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setBirthDate(employee.getBirthDate());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setStatus(employee.getStatus());
        employeeDTO.setDepartment_id(employee.getDepartment_id());
        employeeDTO.getAddresses().addAll(toAddressDTOList(employee));
        employeeDTO.getPhones().addAll(toPhoneDTOList(employee));

        return employeeDTO;
    }

    public List<AddressDTOResponse> toAddressDTOList(Employee employee){
        return employee.getAddresses().stream().map(this::toAddressDTO).toList();
    }

    public List<PhoneDTOResponse> toPhoneDTOList(Employee employee){
        return employee.getPhones().stream().map(this::toPhoneDTO).toList();
    }

    public AddressDTOResponse toAddressDTO(Address address){
        AddressDTOResponse addressDTO = new AddressDTOResponse();
        addressDTO.setZipCode(address.getZipCode());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setNeighborhood(address.getNeighborhood());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());

        return addressDTO;
    }

    public PhoneDTOResponse toPhoneDTO(Phone phone){
        PhoneDTOResponse phoneDTO = new PhoneDTOResponse();
        phoneDTO.setDdd(phone.getDdd());
        phoneDTO.setNumber(phone.getNumber());

        return phoneDTO;
    }

    public DepartmentDTOResponse toDepartmentDTO(Department department){
        DepartmentDTOResponse departmentDTO = new DepartmentDTOResponse();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());

        return departmentDTO;
    }
}
