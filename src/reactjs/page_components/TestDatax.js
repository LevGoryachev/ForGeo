import {ForGeoContext} from "../stores/store";
import React, {useContext, useState} from 'react'

const testDatax = () => {
    const [context, setContext] = useContext(ForGeoContext);
    return (
        (context) => setContext("New Value")

    )

    /*return (
        setContext
           /!* <button onClick={() => setContext("New Value")}>
                Change Context Value
            </button>*!/
    );*/
}

export default testDatax;

/*
export default function ComponentA() {
    const [context, setContext] = useContext(Context);
    return (
        const [geoLocations, setGeoLocations]  =
            ComponentA:
            <button onClick={() => setContext("New Value")}>
                Change Context Value
            </button>

    );
}*/
