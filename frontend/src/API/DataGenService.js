import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/v1/generate"

export class DataGenService {
    static async sendRequest(request) {
        let response = await axios.post(API_BASE_URL, request);
        
        
        // let response = await fetch('https://jsonplaceholder.typicode.com/todos/1');
        // await new Promise(resolve => setTimeout(resolve, 5000));
        return response.data;
    }
}