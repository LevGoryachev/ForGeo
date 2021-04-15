import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import CMainGeoCoordinates from "../components/CMainGeoCoordinates";

const GeoCoordinates = () => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainGeoCoordinates />
            <DClear />
            <EFooter />
        </div>
    );
};

export default GeoCoordinates;