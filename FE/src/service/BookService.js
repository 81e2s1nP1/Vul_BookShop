import { Port } from "../Port";
import axios from "axios";

const API_GETBOOK = `http://localhost:${Port}/api/getall?bookname=`;
// const API_GETBYID = `http://localhost:${Port}/api/todo/getbyid?id=`;
// const API_CREATE = `http://localhost:${Port}/api/todo/create`;
// const API_UPDATE = `http://localhost:${Port}/api/todo/update?id=`;
// const API_DELETE = `http://localhost:${Port}/api/todo/delete?id=`;
// const API_INCOMPLETE = `http://localhost:${Port}/api/todo/`;
// const API_COMPLETE = `http://localhost:${Port}/api/todo/`;

class TodoService {
    getBook(bookname) {
        return axios.get(API_GETBOOK + bookname);
    }

    create(todo) {
        return axios.post(API_CREATE, todo);
    }

    getbyid(id) {
        return axios.get(API_GETBYID + id);
    }

    update(id, todo) {
        return axios.put(API_UPDATE + id, todo);
    }

    delete(id) {
        return axios.delete(API_DELETE + id);
    }

    Complete(id) {
        return axios.patch(API_COMPLETE + id + "/complete");
    }

    inComplete(id) {
        return axios.patch(API_INCOMPLETE + id + "/incomplete");
    }
}

export default new TodoService();