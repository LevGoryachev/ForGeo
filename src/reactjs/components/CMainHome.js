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
                    <a>"Constructions"</a>
                </Link>
            </p>
            <p>
                <Link href={`/geomap`}>
                    <a>"Construction site locations"</a>
                </Link>
            </p>
        </div>
    );
};

export default CMainHome;