import React from 'react';
import {CRUDconstructions} from "../service_components/CRUDConstructions";


//export const ForGeoContext = React.createContext();

/*export const ForGeoLangContext = React.createContext({
    language: "en",
    setLanguage: () => {}
});*/

export function getSyncInitDataInMemory() {
    const constructionsx = [
        { id: 1, codeNumber: 'xxxInitFromFunction', name: 'Construction Site', description: 'cool' },
        { id: 2, codeNumber: 'aaaInitFromFunction', name: 'Construction Site Func', description: 'super cool' },
        { id: 3, codeNumber: 'bbbInitFromFunction', name: 'Construction Site another', description: 'amazing' },
    ];
    console.log(constructionsx);
    return constructionsx;
}

export function getSyncData() {
    const syncState = [
        { id: 1, codeNumber: 'xxxFunction', name: 'Construction Site', description: 'cool' },
        { id: 2, codeNumber: 'aaaFunction', name: 'Construction Site Func', description: 'super cool' },
        { id: 3, codeNumber: 'bbbFunction', name: 'Construction Facility', description: 'amazing' },
        { id: 4, codeNumber: 'cccFunction', name: 'Big Facility', description: 'cool again' },
        { id: 5, codeNumber: 'dddFunction', name: 'Super Facility', description: 'bla-bla-bla' },
    ];
    console.log(syncState);
    return syncState;

}

export function getAsyncDataDB() {
    return CRUDconstructions.getAll()
}

export const ForGeoContext = React.createContext({
    constructionsx: [],
    updConstructions: () => {}
});


/*
export const ForGeoProvider = OurContext.Provider
export const ForGeoConsumer = OurContext.Consumer

export class Provider extends React.Component {
    state = {
        nameA: 'ForGeo module',
        nameB: 'Construction Site Locations'
    }
    render() {
        return (
            <ForGeoProvider value={{...this.state}}>
                {this.props.children}
            </ForGeoProvider>
        )
    }
}*/
