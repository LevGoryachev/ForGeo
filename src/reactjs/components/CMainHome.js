import Headline from "./Headline";
import Link from "next/link";

const CMainHome = () => {
    return (
        <div id="c_main">
            <Headline />
            <h3>Content area</h3>
            <h3>Service for construction site locations</h3>
            <Link href={`/constructions`}>
                <a>"List"</a>
            </Link>
        </div>
    );
};

export default CMainHome;