import axios from "axios";

const API_BASE_URL = "http://localhost:8080/generate"

export class DataGenService {
    static async sendRequest(request) {
        let response = await axios.post(API_BASE_URL, request);
        return response;
    }
}