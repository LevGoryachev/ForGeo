import AHeader from "../page_components/AHeader";
import BSideBar from "../page_components/BSideBar";
import DClear from "../page_components/DClear";
import EFooter from "../page_components/EFooter";
import CMainGeoCoordinates from "../page_components/CMainGeoCoordinates";
import {CRUDlocations} from "../service_components/CRUDLocations";

/*import dynamic from 'next/dynamic'
const DynamicComponent = dynamic(() =>
    import('../components/TestListLocations').then((mod) => mod.Hello)
)*/

const GeoCoordinates = ({geoLocData}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainGeoCoordinates getLoc = {geoLocData} />
            <DClear />
            <EFooter />
        </div>
    );
};
export default GeoCoordinates;

export async function getStaticProps(context) {
    const geoLocData = await CRUDlocations.getAll();
    console.log(geoLocData);
    return {
        props: {geoLocData}, // will be passed to the page component as props
    }
}

/*export async function getStaticProps(context) {
    const response = await fetch('http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2/locations');
    const geoLocData = await response.json();
    console.log(geoLocData);
    return {
        props: {geoLocData}, // will be passed to the page component as props
    }
}*/

