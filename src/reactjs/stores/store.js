import React from 'react';


export const dataInfo = {
    light: {
        foreground: '#000000',
        background: '#eeeeee',
    },
    dark: {
        foreground: '#ffffff',
        background: '#222222',
    },
};


export const ForGeoContext = React.createContext();


/*
export const ForGeoProvider = OurContext.Provider
export const ForGeoConsumer = OurContext.Consumer

export class Provider extends React.Component {
    state = {
        nameA: 'ForGeo module',
        nameB: 'Construction Site Locations'
    }
    render() {
        return (
            <ForGeoProvider value={{...this.state}}>
                {this.props.children}
            </ForGeoProvider>
        )
    }
}*/
