import {ForGeoContext} from "../stores/store";
import React, { useContext } from 'react'

const Headline = () => {
    const [context, setContext] = useContext(ForGeoContext);
    return (
        <div id="headline">
            <h3>Headliner: {context}</h3>
        </div>
    );
};

export default Headline;