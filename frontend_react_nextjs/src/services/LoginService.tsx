import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080'
})

const login = (email: String, password: String) => {
    const response = axiosInstance.post(`/employee/login`, {email, password});
    return response;
}

export default login;