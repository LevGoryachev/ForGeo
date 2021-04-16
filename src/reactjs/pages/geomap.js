import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import CMainGeoMap from "../components/CMainGeoMap";

const GeoMap = ({geoLocData}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainGeoMap getLoc = {geoLocData} />
            <DClear />
            <EFooter />
        </div>
    );
};
export default GeoMap;

export async function getStaticProps(context) {
    const response = await fetch('http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2/locations');
    const geoLocData = await response.json();
    console.log(geoLocData);
    return {
        props: {geoLocData}, // will be passed to the page component as props
    }
}