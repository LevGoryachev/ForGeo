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
                    <a class="mainearbutton buttonblick">Construction sites</a>
                </Link>
            </p>
            <p>
                <Link href={`/geomap`}>
                    <a class="mainearbutton buttonblick">GeoMap locations</a>
                </Link>
            </p>
            <p>
                <Link href={`/coordinates`}>
                    <a class="mainearbutton buttonblick">Coordinates</a>
                </Link>
            </p>
        </div>
    );
};

export default cMainHome;