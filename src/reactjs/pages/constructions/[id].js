import {useRouter} from "next/router";

export default function Construction({construction}) {
    const {query} = useRouter()
    return (
            <div id = "construction">
                <h1>Construction id: {query.id}</h1>
                <div>Name: {construction.codeNumber}</div>
                <div>Name: {construction.name}</div>
                <div>Name: {construction.description}</div>
            </div>
    )
};

