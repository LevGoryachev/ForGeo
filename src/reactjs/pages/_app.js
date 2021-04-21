import '../styles/app.css'
import {ForGeoContext} from "../stores/store";
import React, { useState } from 'react'

// This default export is required in a new `pages/_app.js` file.
export default function MyApp({ Component, pageProps }) {
    const [context, setContext] = useState('default Context');
    return (
        <ForGeoContext.Provider value={[context, setContext]}>
            <Component {...pageProps} />
        </ForGeoContext.Provider>
        )
}