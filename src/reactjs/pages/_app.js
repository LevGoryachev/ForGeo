import '../styles/app.css'
import {
    ForGeoContext,
    getAsyncDataDB,
    getInitialState,
    getInitialStateInMemory, getStaticProps,
    getSyncInitDataInMemory
} from "../stores/store";
import React, { useState } from 'react'
import {CRUDconstructions} from "../service_components/CRUDConstructions";


// This default export is required in a new `pages/_app.js` file.
export default function MyApp({ Component, pageProps }) {

    /*const [language, setLanguage] = useState('default Context');
    const value = {language, setLanguage};*/

    const [constructionsx, updConstructions] = useState(getSyncInitDataInMemory());
    console.log('0st info log' + constructionsx);
    console.log(constructionsx);
    const value = {constructionsx, updConstructions};

    return (
        <ForGeoContext.Provider value={value}>
            <Component {...pageProps} />
        </ForGeoContext.Provider>
        )
}