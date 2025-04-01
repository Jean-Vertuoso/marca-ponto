'use client'

import { TimeEntryButton } from "@/components/button/Button";

export default function TimeEntry(){

    function gritar(){
        alert(`AOOOOOBA`);
    }

    return (
        <div className="bg-radial-[at_50%_25%] from-[#f5f5f5fb] to-[rgba(253,253,253,0.92)] h-screen flex justify-center items-center">
            <TimeEntryButton onClick={gritar}/>
        </div>
    );
}