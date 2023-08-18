const weekInput = document.getElementById('weekInput');
const fondo = document.getElementById('fondo-complete');
const calendarContainer = document.getElementById('calendarContainer');
const selectedDateTimeInput = document.getElementById('selectedDateTime');
let selectedSlot = null;

weekInput.addEventListener('change', updateCalendar);

function updateCalendar() {
    fondo.style.height = 'auto'
    const selectedWeek = weekInput.valueAsDate;
    var count = 1 ;
    calendarContainer.innerHTML = '';

    const tableRows = document.querySelectorAll('table tr');
    const availableSlots = [];

    tableRows.forEach((row, index) => {
        if (index > 0) {
            const date = row.cells[0].textContent;
            const time = row.cells[1].textContent;
            const dateTime = `${date} ${time}`;
            availableSlots.push(dateTime);
        }
    });

    for (let hour = 7; hour <= 20; hour++) {
        const hourDiv = document.createElement('div');
        hourDiv.classList.add('hour-column');
        if (hour != 7){
            hourDiv.innerHTML = `<div class="time-label txt-2-gray" style="font-size: .4rem;">${hour}:00 - ${hour+1}:00</div>`;
        } else {
            hourDiv.innerHTML = `<div class="time-label txt-1-white" style="font-size: .4rem;">${hour}:00 - ${hour+1}:00</div>`;
        }
        for (let day = 1; day <= 6; day++) {
            const currentDate = new Date(selectedWeek);
            currentDate.setDate(currentDate.getDate() + day);
            const slotTime = new Date(currentDate);
            slotTime.setHours(hour, 0, 0, 0);
            let slotDateTime;
            if (slotTime.getDate() != slotTime.toISOString().substring(8,10))
             slotDateTime = slotTime.toISOString().substring(0,8)+slotTime.getDate() + ` ${hour}:00:00`;
            else  slotDateTime = slotTime.toISOString().split('T')[0] + ` ${hour}:00:00`;

            const slotDiv = createSlot(slotDateTime, availableSlots.includes(slotDateTime),hour);
            
            if(slotDiv.outerText.includes('/')){
               slotDiv.innerHTML = addDay(slotDiv.outerText,count);
            count++;
            }
            hourDiv.appendChild(slotDiv);
        }
        calendarContainer.appendChild(hourDiv);
    }
}
function addDay(slotDiv,count){

    switch(count)
    {
        case 1 :
            return `
            <p class="txt-4-green">Lunes</p>
            <p>${slotDiv} </p>
             `;
            
                
        break;
        case 2 :
            return `
            <p class="txt-4-green">Martes</p>
            <p>${slotDiv} </p>
             `;
        break;
        case 3 :
            return `
            <p class="txt-4-green">Miércoles</p>
            <p>${slotDiv} </p>
             `;
        break;
        case 4 :
            return `
            <p class="txt-4-green">Jueves</p>
            <p>${slotDiv} </p>
             `;
        break;
        case 5 :
            return `
            <p class="txt-4-green">Viernes</p>
            <p>${slotDiv} </p>
             `;
        break;
        case 6 :
            return `
            <p class="txt-4-green">Sábado</p>
            <p>${slotDiv} </p>
             `;
        break;
    }
}


function createSlot(dateTime, isAvailable,hour) {
    const slot = document.createElement('div');
    if ((hour != 20) & (hour != 7)) {
        slot.classList.add('slot');
        slot.classList.add('txt-1-white');
        slot.classList.add('borde');
        slot.classList.add('hov'); 
        
    } else {
        if (hour == 7) {
            slot.classList.add('slot');
            slot.classList.add('dia1');                   
            slot.classList.add('txt-2-gray-v2');
            slot.classList.add('borde'); 
                               
        }
        if (hour == 20) {
            slot.classList.add('slot');
            slot.classList.add('dia2');
            slot.classList.add('txt-1-white');
            slot.classList.add('borde');
            slot.classList.add('hov'); 
            
        }
    }

    slot.dataset.date = new Date(dateTime).toDateString();
    const date = new Date(dateTime);
    const dayOfWeek = date.getDay();
    let hora = hour;

    if (isAvailable) {
        slot.classList.add('unavailable');
        slot.textContent = '';
    } else {
        if (hora != 7) {
            const formattedDateTime = `${date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}`;
            slot.textContent = formattedDateTime;
            slot.addEventListener('click', () => {
                if (selectedSlot) {
                    selectedSlot.classList.remove('selected');
                }
                selectedSlot = slot;
                slot.classList.add('selected');
                selectedDateTimeInput.value = dateTime;
            });
        } else {
            const formattedDateTime = `${date.toLocaleDateString()}`;
            slot.textContent = formattedDateTime;
        }
    }

    return slot;
}