/**
 * Enters. Does literally nothing for five seconds. Leaves.
 */
export async function doNothingForFiveSeconds() {
    return new Promise<void>(resolve => {
        // Imagine this is your application communicating with the backend!
        setTimeout(() => {
            resolve();
        }, 5000);
    });
}
