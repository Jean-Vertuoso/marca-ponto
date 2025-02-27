package br.com.horadoponto.business.converters;

import java.util.List;

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

    // PARTE QUE CONVERTE DE DTO PARA DTO
    public Employee toEmployee(EmployeeDTO employeeDTO){
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

    public List<Address> toAddressList(EmployeeDTO employeeDTO){
        return employeeDTO.getAddresses().stream().map(this::toAddress).toList();
    }

    public List<Phone> toPhoneList(EmployeeDTO employeeDTO){
        return employeeDTO.getPhones().stream().map(this::toPhone).toList();
    }

    public Address toAddress(AddressDTO addressDTO){
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

    public Phone toPhone(PhoneDTO phoneDTO){
        Phone phone = new Phone();
        phone.setDdd(phoneDTO.getDdd());
        phone.setNumber(phoneDTO.getNumber());

        return phone;
    }

    // PARTE QUE CONVERTE DE DTO PARA ENTIDADE
    public EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

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

    public List<AddressDTO> toAddressDTOList(Employee employee){
        return employee.getAddresses().stream().map(this::toAddressDTO).toList();
    }

    public List<PhoneDTO> toPhoneDTOList(Employee employee){
        return employee.getPhones().stream().map(this::toPhoneDTO).toList();
    }

    public AddressDTO toAddressDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setZipCode(address.getZipCode());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setNeighborhood(address.getNeighborhood());
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
