import Headline from "./Headline";

const Constructions = (props) => {

    return (
        <div id="c_main">
            <Headline />
            <h2>List of constructions:</h2>
            <ul>
                {props.getCon.map((construction) =>
                    <li>
                        {construction.id}, {construction.codeNumber}, {construction.name}: {construction.description}
                    </li>
                )}
            </ul>
        </div>
    );
};

export default Constructions;