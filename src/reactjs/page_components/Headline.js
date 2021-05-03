import {ForGeoContext} from "../stores/store";
import React, { useContext } from 'react'

const Headline = () => {
    const [language, setLanguage] = useContext(ForGeoContext);
    return (
        <div id="headline">
            {/*<h3>Headliner: {language}</h3>*/}
        </div>
    );
};

export default Headline;