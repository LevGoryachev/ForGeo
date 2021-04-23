//import { apiUrl } from 'config';
import {fetchWrapper} from "./FetchWrapper";


export const CRUDlocations = {
    getAll,
    getById,
    create,
    update,
    delete: _delete
};

const apiUrl = `http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2`
const baseUrl = `${apiUrl}/locations`;

function getAll() {
    return fetchWrapper.get(baseUrl);
}

function getById(id) {
    return fetchWrapper.get(`${baseUrl}/${id}`);
}

function create(params) {
    return fetchWrapper.post(baseUrl, params);
}

function update(id, params) {
    return fetchWrapper.put(`${baseUrl}/${id}`, params);
}

// prefixed with underscored because delete is a reserved word in javascript
function _delete(id) {
    return fetchWrapper.delete(`${baseUrl}/${id}`);
}