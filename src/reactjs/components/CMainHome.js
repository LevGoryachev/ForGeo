import Headline from "./Headline";
import Link from "next/link";

const CMainHome = () => {
    return (
        <div id="c_main">
            <Headline />
            <h3>Content area</h3>
            <h3>Service for construction site locations</h3>
            <p>
                <Link href={`/constructions`}>
                    <a>"List of construction sites"</a>
                </Link>
            </p>
            <p>
                <Link href={`/geomap`}>
                    <a>"GeoMap locations"</a>
                </Link>
            </p>
            <p>
                <Link href={`/coordinates`}>
                    <a>"List of coordinates"</a>
                </Link>
            </p>
        </div>
    );
};

export default CMainHome;