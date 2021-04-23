import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import CMainGeoMap from "../components/CMainGeoMap";
import {CRUDlocations} from "../service_components/CRUDLocations";

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
    const geoLocData = await CRUDlocations.getAll();
    console.log(geoLocData);
    return {
        props: {geoLocData}, // will be passed to the page component as props
    }
}