import {useState} from 'react'
import Headline from "./Headline";

const GeoCoordinates = () => {
    //test list:
    const [geoLocations, setGeoLocations]  = useState([
        {id: 1, lat: 36.124, lng: -115.122,  postalAddr: 'Palkino, Centralnyaya', constrAddr: 'Palkino 4', isLinear: false},
        {id: 1, lat: 48.6789586, lng: -111.3465,  postalAddr: 'Tarelkino, Obvodnaya, 24', constrAddr: 'Tarelkino, Obvodnaya, 13A', isLinear: false},
        {id: 1, lat: 38.4358, lng: -122.80293,  postalAddr: '3451, Fairbear, Swislandzangang', constrAddr: 'Fairbear-1', isLinear: false},
        {id: 1, lat: 31.723, lng: -114.1999,  postalAddr: 'Laitghtenstain, 17893', constrAddr: 'Laitghtenstain', isLinear: true},
        {id: 1, lat: 31.47644, lng: -118.75893,  postalAddr: 'Birka, Lopals, Obritan-Keramic-14, A180', constrAddr: 'Lopals A180-B', isLinear: true},
    ])

    return (
        <div id="c_main">
            <Headline />
            <h2>List of coordinates:</h2>
            <ul>
                {geoLocations.map(geoLocation =>
                    <li>
                        {geoLocation.id}, {geoLocation.lat}, {geoLocation.lng}, {geoLocation.postalAddr}, {geoLocation.constrAddr}, {geoLocation.isLinear}
                    </li>
                )}
            </ul>
        </div>
    );
};

export default GeoCoordinates;