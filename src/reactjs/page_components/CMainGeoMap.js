import {useState} from 'react'
import Headline from "./Headline"
import dynamic from 'next/dynamic'

const GeoMap = (props) => {

     return (
        <div id="c_main">
            <Headline />
            <h2>GeoMap (test list of locations):</h2>
            <ul>
                {props.getLoc.map(geoLocation =>
                    <li>
                        {geoLocation.id}, {geoLocation.lat}, {geoLocation.lng}, {geoLocation.postalAddr}, {geoLocation.constrAddr}, {geoLocation.isLinear}
                    </li>
                )}
            </ul>
        </div>
    );
};

export default GeoMap;