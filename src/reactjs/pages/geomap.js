import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import CMainGeoLocations from "../components/CMainGeoLocations";

const GeoMap = () => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainGeoLocations />
            <DClear />
            <EFooter />
        </div>
    );
};

export default GeoMap;