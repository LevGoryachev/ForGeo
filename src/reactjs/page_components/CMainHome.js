import Headline from "./Headline";
import Link from "next/link";

const cMainHome = () => {
    return (
        <div id="c_main">
            <Headline />
            <h3>Content area</h3>
            <h3>Service for construction site locations</h3>
            <p>
                <Link href={`/constructions`}>
                    <button className="mainearbutton buttonblick">Construction sites</button>
                </Link>
            </p>
            <p>
                <Link href={`/geomap`}>
                    <button className="mainearbutton buttonblick">GeoMap locations</button>
                </Link>
            </p>
            <p>
                <Link href={`/coordinates`}>
                    <button className="mainearbutton buttonblick">Coordinates</button>
                </Link>
            </p>
        </div>
    );
};

export default cMainHome;