import React from 'react';
import {CRUDconstructions} from "../service_components/CRUDConstructions";


//export const ForGeoContext = React.createContext();

/*export const ForGeoLangContext = React.createContext({
    language: "en",
    setLanguage: () => {}
});*/

export function getSyncInitDataInMemory() {
    const constructionsx = [
        { id: 1, codeNumber: 'InMemory test data - code number 1', name: 'Construction Site name A - test data', description: 'This is InMemory frontend test data. Probably backend service is unavailable' },
        { id: 2, codeNumber: 'InMemory test data - code number 2', name: 'Construction Site name B - test data', description: 'This is InMemory frontend test data. Probably backend service is unavailable' },
        { id: 3, codeNumber: 'InMemory test data - code number 3', name: 'Construction Site name C - test data', description: 'This is InMemory frontend test data. Probably backend service is unavailable' },
    ];
    return constructionsx;
}

export function getAsyncDataDB() {
    return CRUDconstructions.getAll()
}

export const ForGeoContext = React.createContext({
    constructionsx: [],
    updConstructions: () => {}
});

