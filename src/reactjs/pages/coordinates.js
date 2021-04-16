import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import CMainGeoCoordinates from "../components/CMainGeoCoordinates";

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
    const response = await fetch('http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2/locations');
    const geoLocData = await response.json();
    console.log(geoLocData);
    return {
        props: {geoLocData}, // will be passed to the page component as props
    }
}

