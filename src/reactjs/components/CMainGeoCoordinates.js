import Headline from "./Headline";

const GeoCoordinates = (props) => (

        <div id="c_main">
            <Headline />
            <h2>List of coordinates:</h2>
            <ul>
                {props.getLoc.map((geoLocations) =>
                    <li>
                        {geoLocations.id}, {geoLocations.lat}, {geoLocations.lng}, {geoLocations.postalAddr}, {geoLocations.constrAddr}, {geoLocations.isLinear}
                    </li>
                )}
            </ul>
        </div>
);

export default GeoCoordinates;