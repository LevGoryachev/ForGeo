import {useState} from 'react'

const Constructions = () => {
    //test list:
    const [constructions, setConstructions]  = useState([
        {id: 1, codeNumber: 'TP-007', name: 'Palkino', description: '5-storey facility'},
        {id: 2, codeNumber: 'TP-014', name: 'Elkino', description: '8-storey facility'},
        {id: 3, codeNumber: 'TP-021', name: 'Kopalkino', description: 'shed'},
    ])

    return (
        <div>
            <h2>List of constructions:</h2>
            <ul>
                {constructions.map(construction =>
                    <li>
                        {construction.codeNumber}, {construction.name}: {construction.description}
                    </li>
                )}
            </ul>
        </div>
    );
};

export default Constructions;